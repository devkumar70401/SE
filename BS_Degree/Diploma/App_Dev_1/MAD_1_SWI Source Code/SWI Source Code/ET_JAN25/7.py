from flask import Flask, abort, request

app = Flask(__name__)

@app.route('/validate/<int:number>')
def validate_number(number):
    if number % 2 == 0 and number % 3 == 1:
        abort(400, "Bad Request: Invalid number provided")
    return f'<h1>Valid Number: {number}</h1>'

app.run(debug=True)