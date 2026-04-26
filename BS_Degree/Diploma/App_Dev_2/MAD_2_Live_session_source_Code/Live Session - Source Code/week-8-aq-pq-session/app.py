from flask import Flask, request, jsonify 
from flask_sqlalchemy import SQLAlchemy
from flask_jwt_extended import JWTManager, create_access_token, jwt_required, current_user

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///jwt-data.sqlite3"
app.config["JWT_SECRET_KEY"] = "my-jwt-secret-key"
db = SQLAlchemy(app)
jwt = JWTManager(app)
app.app_context().push()


@jwt.user_identity_loader # with what you want to Identify
def load(user):
    return user.username # identity

@jwt.user_lookup_loader # How do you want to load the user
def user_lookup(_jwt_header, jwt_data):
    identity = jwt_data["sub"]
    return User.query.filter_by(username = identity).one_or_none()

class User(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String(), unique = True, nullable = False)
    password = db.Column(db.String(), nullable = False)

@app.route('/login', methods = ["POST"])
def user_login():
    # username = request.json.get('username', None)
    # password = request.json.get('password', None)
    user_cred = request.get_json() 
    # user_cred = {
    #         "username": "user_01", 
    #         "password": "1234"
    #     }

    user = User.query.filter_by(username = user_cred["username"]).one_or_none() # .first() => <user >, None
    
    if not user or not user.password == user_cred["password"]:
        # return {
        #     "message": "incorrect username or password"
        # }, 401
        return jsonify(message = "incorrect username or password"), 401
    
    created_access_token = create_access_token(identity = user)

    return jsonify(access_token = created_access_token)

@app.route('/dashboard')
@jwt_required()
def user_dashboard():
    print(current_user)
    return {
        "message": "user fetched successfully",
        "username": current_user.username,
        "password": current_user.password,
        "user_id": current_user.id
    }

# @app.route('/profile')
# @jwt_required()


    # {
    #     "access_token": "eykgckbslcnlskcn;lm"
    # }
    
    # if not user:
    #     return {
    #         "message": "User with given username does not exist"
    #     }, 400
    # else: # user exists ==> user object has proper values
    #     if not user.password == password:
    #         return {
    #             "message": "Invalid password"
    #         }, 400
    #     else:
    #         return {
    #             "message": "User found"
    #         }
if __name__ == "__main__":
    app.run(debug = True)


# user login ----> token created (with the help of user information) ---> retrieve user info
    

# eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTc2Mjg3NzgyNywianRpIjoiYmFmNjE5ODAtYTM5Zi00NmU5LWFjNzctYTM1Y2ZhMmRkMDc3IiwidHlwZSI6ImFjY2VzcyIsInN1YiI6InVzZXJfMDEiLCJuYmYiOjE3NjI4Nzc4MjcsImNzcmYiOiI1ODhhYjY3Ny0wN2ZmLTRiMDktYTg2Zi02Zjk5MDI3NzY3YTciLCJleHAiOjE3NjI4Nzg3Mjd9.0-4gs-2La0seGLiqKGtSs9HwYu1hY4jSOwdKa112euQ

# user = {
#     "username": "user_02",
#     "password": "54321"
# } = current_user