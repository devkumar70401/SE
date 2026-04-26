from flask import Flask,request
app=Flask(__name__)

# @app.route("/details/<int:id>/<string:name>")
# def show(id,name):
#     details ={"student_id":id,"student_name":name}
#     return details

# @app.route("/details/<string:id>/<string:name>")
# def show(id,name):
#     details ={"student_id":id,"student_name":name}
#     return details

@app.route("/details/<id>/<name>")
def show(id,name):
    details ={"student_id":id,"student_name":name}
    return details

# @app.route("/details/<int:id>/<int:name>")
# def show(id,name):
#     details ={"student_id":id,"student_name":name}
#     return details

app.run(debug=True)