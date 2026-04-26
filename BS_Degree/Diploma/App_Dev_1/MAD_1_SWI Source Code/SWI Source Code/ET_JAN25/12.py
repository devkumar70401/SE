from flask import Flask, render_template, url_for, request, redirect
app = Flask(__name__)
list_of_courses = ['Java', 'Python', 'DBMS', 'PDSA']

@app.route("/if")
def if_loop():
	name = request.args.get("name")
	if name == "MADI":
		return redirect("/home")
	elif name in list_of_courses:
		# return url_for("for_loop")
		return redirect(url_for("for_loop"))
	return "You are not authorized to view this page"

@app.route("/home")
def home_page():
	return "Welcome to MADI!"

@app.route("/for")
def for_loop():
	return render_template("for_course.html", courses=list_of_courses)
	
app.run(debug=True)