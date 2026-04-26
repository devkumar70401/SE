from flask import Flask
app = Flask(__name__)

@app.route('/')
def generate1():
    return "This is generate1"

@app.route('//')
def generate2():
    return "This is generate2"

@app.errorhandler(404)
def page_not_found(e):
    # setting 404 status explicitly
    return 'page not found'

app.run()