<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expense</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#deleteExpense").hide();
     $("#updateExpense").hide();
    
    $("#update").click(function(){
        $("#updateExpense").show();
        $("#deleteExpense").hide();
    });
    $("#delete").click(function(){
        $("#deleteExpense").show();
         $("#updateExpense").hide();
    });


// Alerts
	$("#Addbtn").click(function () {
       alert("Added Successfully");
    });

	$("#updateExpense").click(function () {
       alert("updated Successfully");
    });

	$("#deleteExpense").click(function () {
       alert("Deleted Successfully");
    });
});

</script>
</head>
<body class="container container-fluid">
	<div id="add">
		<h1 style="text-align: center;">EXPENSE TO DO</h1>
		<form action="ExpenseController" method="GET">
			<table class="table">
				<tr >
					<td style="text-align: center;">Expense Name:
						<br>
						<input type="text" name="name" placeholder="Type Name Here"></td>
				</tr>
				<tr >
					<td style="text-align: center;">Expense Price:
						<br>
						<input type="range" value="0" name="price" min="0" max="5000" oninput="this.nextElementSibling.value = this.value"> <output>0</output></td>
				</tr>
				<tr >
					<td style="text-align: center;">Expense Date:
						<br>
					<input type="date" name="date"></td>
				</tr>
				<tr >
					<td style="text-align: center;">Expense Color:
						<br>
						<input type="color" name="color"></td>
				</tr>
				<tr >
					<td style="text-align: center;">Expense URL:
						<br>
						<input type="url" name="url" placeholder="Type URL here"></td>
				</tr>
				<tr >
					<td style="text-align: center;">Expense Remarks:
						<br>
						<textarea rows="3" cols="60" name="review" placeholder="Type Remarks here"></textarea></td>
				</tr>
				

				
			</table>
		<div style="text-align: center; width:100%">
		<button class="btn btn-primary"  type="submit" id="Addbtn" name="addExpense" value="Add"> + ADD</button>
		
		
		</div>
		</form>
	</div>
    <div class="mt-3">
		<div style="display: inline-flex;">

			<h1 style="margin-left: 40px;">Expenses List:</h1> 
			<button class="btn btn-dark" style="margin-left: 700px"  type="submit" formmethod="post" name="showExpense" value="Show">SHOW LIST</button>
		</div>
		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Expense Name</th>
					<th scope="col">Expense Price</th>
					<th scope="col">Expense Date</th>
					<th scope="col">Expense Color</th>
					<th scope="col">Expense URL</th>
					<th scope="col">Expense Remark</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="exp" items="${ExpenseList}">
					<tr>
						<th scope="row">${exp.id}</th>
						<td>${exp.ename}</td>
						<td>${exp.price}</td>
						<td>${exp.date}</td>
					    <td><input type="color" value="${exp.color}" disabled></td> 
					    <td>${exp.url}</td>
						<td>${exp.review}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<form name="formid" action="ExpenseController" method="POST">
			<br>Select ID of Expense for update or delete:  <select class="browser-default custom-select" name="id" onchange="document.getElementById('butn').click()">
			    <option value="">selectID</option>
				<c:forEach items="${ExpenseList}" var="Expense">
     			
     				<option value="${Expense.id}" ${record.id == Expense.id ? 'selected' : ''}>${Expense.id}</option>
     				
				</c:forEach>
			</select> 
			<input class="btn btn-white mt-2" type="submit" hidden="true" id="butn" value="Fill existing field values" name="showInfo" formmethod="get">
			<br>
			<br>
			<div class="d-flex flex-column ">
			<div><input type="radio" id="update" name="choice" onclick="document.getElementById('hiddenUpdate').hidden=!this.checked;" ${empty record ? 'disabled': ''}>   Update</div>
			<div><input type="radio" id="delete" name="choice" 
				onclick="document.getElementById('hiddenUpdate').hidden=this.checked;" ${empty record ? 'disabled': ''}>   Delete<br>
				</div></div>
			<div id="hiddenUpdate" hidden="true" >
			<table class="table mt-3">
				<tr >
					<td>Update Expense Name:</td>
					<td><input type="text" id="nameupdate" name="nameupdate" value="${record.name}"></td>
				</tr>
				<tr >
					<td>Update Expense Price:</td>
					<td><input type="text" id="priceupdate" name="priceupdate" value="${record.price}" ></td>
				</tr>
				<tr >
					<td>Update Expense Date:</td>
					<td><input type="date" id="dateupdate" name="dateupdate" value="${record.date}" ></td>
				</tr>
				<tr >
					<td>Update Expense Color:</td>
					<td><input type="color" id="colorupdate" name="colorupdate" value="${record.color}" ></td>
				</tr>
				<tr >
					<td>Update Expense URL:</td>
					<td><input type="url" id="urlupdate" name="urlupdate" value="${record.url}" ></td>
				</tr>
				<tr >
					<td>Update Expense Remark:</td>
					<td><textarea rows="4" cols="50" name="reviewupdate" id="reviewupdate">${record.review}</textarea></td>
				</tr>
			</table>
			</div>	
			<button type="submit" class="btn btn-success" id="updateExpense" name="updateExpense">
				UPDATE</button>
			<br> <br>
			<button class="btn btn-danger" type="submit" id="deleteExpense" name="deleteExpense">
				DELETE</button>




		</form>
	</div>
	
</body>
</html>
