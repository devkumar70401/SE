from flask import Flask
app = Flask(__name__)

@app.route('/home/<path:url_path>')
def course(url_path):   
    return 'The path is: ' + url_path

@app.route('/home/details/<student_id>/<course_id>')
def home(student_id, course_id):
    return f'The student-id and course-id are {student_id} and {course_id} respectively.' 

@app.route('/home/student/<student_id>/<course_id>')
def details(student_id, course_id):
    details = {'course_id': course_id,'student_id': student_id}
    return details
    
app.run(debug=True)