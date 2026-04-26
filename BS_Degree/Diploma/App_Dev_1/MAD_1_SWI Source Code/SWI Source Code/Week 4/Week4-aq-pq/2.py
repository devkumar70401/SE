from flask import Flask, url_for

app = Flask(__name__)

@app.route('/home')
def index():
    return 'Mad-I welcomes you!'

@app.route('/user/<username>') #string
def profile(username):
    return f'{username}\'s profile'

with app.test_request_context():
    print(url_for('index'))
    print(url_for('profile', username='Harry'))
    print(url_for('profile', username='Harry', next='course'))
    print(url_for('index', username='Harry'))

# app.run(debug=True)