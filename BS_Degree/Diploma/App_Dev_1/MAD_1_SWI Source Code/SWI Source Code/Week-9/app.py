from flask import Flask, render_template, request, redirect 
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager, UserMixin, current_user, login_user, login_required, logout_user

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///auth_db.sqlite3"  # sqlite:///<db_name>.<extension>
app.config["SECRET_KEY"] = "this-is-secret-key"
 

db = SQLAlchemy()
db.init_app(app)

login_manager = LoginManager()
login_manager.init_app(app)

@login_manager.user_loader # this function is triggered when login_user(user) is called. It stores the user information in cookies
def load_user(id):
    return User.query.get(id)

app.app_context().push() 

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String, nullable = False, unique = True)
    password = db.Column(db.String, nullable = False)

@app.route('/login', methods = ['GET', 'POST'])
def user_login():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')
        user = User.query.filter_by(username = username).first()
        if user:
            if user.password == password:
                login_user(user)
                # return redirect('/dashboard/'+ str(user.id))
                return redirect(f'/dashboard')
            else:
                return "Incorrect Password"
        else:
            return "User Not Found!"
    return render_template('login.html')

@app.route('/dashboard') #/dashboard
@login_required
def dashboard():
    user = current_user #<User 1>
    return render_template('dashboard.html', user = user)
    # user = User.query.filter_by(id = id).first()
    # user = User.query.filter_by(id = id).all()

    # user = [<user 01>] - all()
    # user = <user 01> - first()
@app.route('/logout')
@login_required
def user_logout():
    logout_user()
    return redirect('/login')
# http://127.0.0.1:5000/dash

if __name__ == "__main__":
    app.run(debug = True)

# user -> table
# User -> class

# user ----> session (encrypted)(mechanism) -----> current_user(secret-key, mechanism)


# encrypted = secret-key + user-info

# .eJwlzjkOwjAQAMC_uKbYtfcin4nsPQRtIBXi70SinG4-ba8jX4-2vY8zb21_RttaShTbzGkpvcDvnq7cgZzEUNYF04V98TC1bsKsQyQ8WBlgpaJ6nwpEPO_klh40XNWGFi2gItMyAVxYqKAIwVGjj3ScK9oVOV95_DfYvj-PzC6N.Z9GcjA.PDZt6NA607B28RuTtqegf0B2EyQ