#pip install flask
from flask import Flask
app = Flask(__name__)#variable and module name can be anything

# def name():
#     print("hello world")

# name()
@app.route("/")#binds URl with the def written below it
# @app.route("/home")
def home():
    return "hello world"

# @app.route("/one")
# def home():  #assertion error
#     return "<h1>This is index page</h1>"

@app.route("/one")
def index():  
    return "<h1>This is index page</h1>"

#by default get method, post method you will have to define it explicitly 

@app.route("/two")
def two():
    return "<h1>This is second webpage</h1>"
# @app.route("/one")
# def two():
#     return "<h1>This is second webpage</h1>"  default 

@app.route("/three")
def three():
    return "<h1>This is third webpage</h1>"

@app.route("/four")
def four():  
    return "<h1>This is fourth webpage</h1>"
app.run(debug=True)

#app.run() restart everytime while making changes to code
#app.run(debug=True) no need to restart, change is detected by itself and new changes are incorporated
