from flask import Flask,request
app = Flask(__name__)

@app.route('/employee', methods = ['GET', 'POST'])
def show_details():
    det = request.args
    details = {
                'Department': det['dept'],
                'Id': det['id'],
                'Profession': det['prof']
            }
    return details

app.run(debug=True)