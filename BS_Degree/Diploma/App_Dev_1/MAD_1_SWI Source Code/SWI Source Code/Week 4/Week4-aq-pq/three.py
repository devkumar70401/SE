from flask import Flask,render_template,request,redirect,url_for

app = Flask(__name__,template_folder="views")

@app.route("/")
def home():
    return render_template("form.html")

@app.route("/course")
def course():
    # return redirect("/")
    return redirect(url_for("home"))#url_for takes function name as argument

app.run(debug=True)