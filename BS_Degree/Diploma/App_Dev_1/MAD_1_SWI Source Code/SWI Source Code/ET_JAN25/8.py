from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def index():
  return render_template("index.html", links=['hoME', 'PROfile', 'Contact', 'SITEMAP'])

app.run(debug=True)