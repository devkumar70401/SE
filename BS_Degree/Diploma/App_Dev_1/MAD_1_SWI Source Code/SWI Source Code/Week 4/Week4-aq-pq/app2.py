from flask import Flask,render_template,request,redirect,url_for

app = Flask(__name__,template_folder="views")

@app.route("/course",methods=["POST","GET"])
def form():
    if request.method=="GET":
        return render_template("form.html")
    if request.method == "POST":
        course = request.form["course"]
        return render_template("course.html",course=course)

@app.route("/one")
def one():
    return "hello"

@app.route("/two")
def two():
    # return redirect("/one")
    return redirect(url_for("one")) 
app.run(debug=True)