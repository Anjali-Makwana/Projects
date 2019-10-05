<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/d3/3.4.11/d3.js"></script>
  <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.js"></script>
  <link href="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#cce6ff">

<div id="chart"></div>
<script type="text/javascript">
 
var chart = c3.generate({
	bindto: "#chart",

    data: {
        type: 'bar',
        json: [
            { 'indicator': 'X', 'total': 100 },
            { 'indicator': 'Y', 'total': 200 },
            { 'indicator': 'Z', 'total': 300 }
        ],
        mimeType:'json',
        keys: {
            x: 'indicator',
            value: ['total']
        }
    },
    axis: {
            x: {
                type: 'category'
            }
    },
    bar: {
        width: {
            ratio: 0.5
        }
    }
});

</script>
</body>
</html>