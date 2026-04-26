
#server end
# 1. send form (register.html) /register
# 2. get info from user

#clients end:
# 1. form appeared (/register), entered info
# 2. review page should come from server which will have all my info
#final submit goes to /success

from flask import Flask, render_template, request

app = Flask(__name__)

@app.route("/register", methods=["POST", "GET"])
def register():
    # if request.method=="GET":
    #     return render_template("register.html")
    if request.method=="POST":
        name = request.form.get("name")
        gender = request.form.get("gender")
        age = request.form.get("age")
        qual = request.form.get("qual")
        stream = request.form.get("stream")
        address = request.form.get("address")
        return render_template("review.html", name=name, gender=gender, age=age, qual=qual, stream=stream, address=address)#LHS>jinja, RHS>data variables
    
    return render_template("register.html")

@app.route("/success")
def success():
    return "<h5> Your registration is successful!</h5>"

app.run(debug=True)
#by default get method is triggered
