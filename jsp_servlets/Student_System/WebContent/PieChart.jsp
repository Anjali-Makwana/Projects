<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/d3/3.4.11/d3.js"></script>
  <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.js"></script>
  <link href="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.css" rel="stylesheet" type="text/css">
</head>
<body>
<% String jsonData = (String)request.getAttribute("jsonList"); %>
<div id="chart"></div>
<script type="text/javascript">
setTimeout(function () {
	
	var chart = c3.generate({
		bindto: "#chart",
	    data: {
	        // iris data from R
	        columns: [
	            ['data1', 30],
	            ['data2', 120],
	        ],
	        type : 'pie',
	        onclick: function (d, i) { console.log("onclick", d, i); },
	        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
	        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
	    }
	});
}, 1000);
</script>
</body>
</html>