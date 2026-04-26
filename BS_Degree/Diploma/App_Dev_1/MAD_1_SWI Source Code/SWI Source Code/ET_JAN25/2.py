from flask import Flask,request
app=Flask(__name__)

@app.route("/get_value")
def get_value():
    val1=request.args.get("val1")
    return "The value is "+val1

app.run(debug=True)