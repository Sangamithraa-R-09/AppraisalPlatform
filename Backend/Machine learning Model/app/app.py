from flask import request,jsonify,Flask,Response
from flask_cors import CORS
import pandas as pd
import pickle
from sklearn import preprocessing
import plotly.graph_objects as go


app=Flask(__name__)
CORS(app,origins='*')


@app.route('/')
def home():
    return "<h1 style='text-align:center;'>Welcome to Predictor API<h1>"


@app.route('/predict',methods=['POST'])
def predictRating():
    data=request.get_json()
    d=dict()
    for key in data:
        d[key]=[data[key]]
    d=pd.DataFrame(d)
    model=pickle.load(open('predictor.sav','rb'))
    predict=model.predict(d)
    predict=float(predict[0]).__round__(2)
    while predict:
        if predict<5:
            break
        predict=predict/2
    return jsonify({"rating":predict.__round__(2)})



@app.route('/graph/growth',methods=['POST'])
def GrowthGraph():
    data=request.get_json()
    d=dict()
    for key in data:
        d[key]=[data[key]]
    d=pd.DataFrame(d)
    fig = go.Figure()

    fig.add_trace(go.Scatterpolar(
        r=d.values[0],
        theta=d.columns,
        fill='toself',
        line=dict(color='cyan')
    ))

    fig.update_layout(
        polar=dict(
            bgcolor='rgba(0,0,0,0)',  
            radialaxis=dict(
                tickvals=[],
            ),
        ),
        paper_bgcolor='rgba(0,0,0,0)',  
        font=dict(
            color='black',  
            size=17,  
        )
    )
    imgage=fig.to_image(format='png')
    response = Response(imgage, content_type="image/png")
    return response



if __name__=='__main__':
    app.run(debug=True)