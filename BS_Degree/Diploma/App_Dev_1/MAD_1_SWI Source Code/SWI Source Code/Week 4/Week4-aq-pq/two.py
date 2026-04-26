from flask import Flask,render_template,request
app = Flask(__name__)

@app.route("/")
def home():
    return render_template("course.html")

@app.route("/one",methods=["GET","POST"])#combination of URL and method gives unique resource 
def index():
    if request.method == "GET":
        return render_template("f_data.html")
        # return render_template("form.html")
    if request.method == "POST":
        # course = request.form["c_name"]
        # id_name = request.form.get("id")
        # return render_template("course.html",j1=course,j2=id_name)
        c_name = request.form["c_name"]
        id = request.form.get("id")
        return render_template("course.html",c_name=c_name,id=id)#lhs>jinja, rhs>form data

app.run(debug=True)
#get: get me the data, used to retrieve info from server 
# ex. facebook.com, gives login form
#post: used to send data to the server, post the data
# filling the data in the form and sumitting it, method becomes post
#render_template function by default look for html file in templates folder otherwise template not found error

#debug=True> 1. detects change, 2. gives debug info
#development> debug=True, debug info
#production> debug=False we dont want the users to know at what point my app is crashing.