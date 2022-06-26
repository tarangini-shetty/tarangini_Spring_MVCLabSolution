<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
    crossorigin="anonymous">
<title>Student Registration form</title>
</head>
<body>
<h3> Student Form for ${mode}</h3>

            <form action="save" method="POST">
                <input type="hidden" name="studentId" value="${student.studentid}" />
                <input type="text" name="firstName" value="${student.firstname}" placeholder="First Name" class="form-control mb-4 col-4">
                <input type="text" name="lastName" value="${student.lastname}" placeholder="Last Name" class="form-control mb-4 col-4">
                <input type="text" name="course" value="${student.course}" placeholder="Course" class="form-control mb-4 col-4">
                <input type="text" name="country" value="${student.country}" placeholder="Country" class="form-control mb-4 col-4">
                <button type="submit" class="btn btn-info col-2">Save</button>
            </form>
            <a href="list" class="btn btn-primary btn-sm mb-3">Back to Students List</a>
<div class="container">
</div>
</body>

</html>