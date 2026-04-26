from flask import Flask

app = Flask(__name__)

@app.route('/home')
@app.route('/work')
def my_task():
    return "<h1>Hello! Reporting for my task</h1>"

app.run()

