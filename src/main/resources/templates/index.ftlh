<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css"/>
</head>
<body>
<div class="payrolls">
    <h1>Payrolls </h1>
    <a href="/">Show All</a>
    <form action="/addPayroll" method="post">
        <label>
            <input type="number" name="employeeId">
            <input type="date" name="startDate" placeholder="StartDay">
            <input type="date" name="endDate" placeholder="EndDay">
            <input type="number" name="amount" placeholder="Amount">
        </label>
        <button>Add</button>
    </form>
    <table>
        <td>Id</td>
        <td>Employee Id</td>
        <td>Start Day</td>
        <td>End Day</td>
        <td>Amount</td>
        </tr>
        <#list payrollList as payroll>
            <tr>
                <td>${payroll.id}</td>
                <td>${payroll.employeeId}</td>
                <td>${payroll.startDate}</td>
                <td>${payroll.endDate}</td>
                <td>${payroll.amount}</td>
                <td><a href="${'/deletePayroll/'+payroll.id}">Delete</a></td>
            </tr>
        </#list>
    </table>
</div>
<div>
    <h1>Employees</h1>
</div>
<form action="/add" method="post">
    <label>
        <input type="text" name="Name" placeholder="Name">
        <input type="text" name="Department" placeholder="Department">
        <input type="text" name="Post" placeholder="Post">
        <input type="text" name="Contact" placeholder="Contact">
        <input type="date" name="DateEmployment" placeholder="Date of employment">
    </label>
    <button>Add</button>
</form>
<br>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Department</td>
        <td>Post</td>
        <td>Contact</td>
        <td>Date of employment</td>
        <td>Payrolls</td>
    </tr>
    <#list employeeList as employee>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.department}</td>
            <td>${employee.post}</td>
            <td>${employee.contact}</td>
            <td>${employee.dateEmployment}</td>
            <td><a href="${'/showPopUp/'+employee.id}">Show</a></td>
            <td><a href="${'/delete/'+employee.id}">Delete</a></td>
        </tr>
    </#list>
</table>
</body>
</html>