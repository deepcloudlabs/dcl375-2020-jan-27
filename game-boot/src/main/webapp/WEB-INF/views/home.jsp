<html>
<head>
    <title>Number Guess Game</title>
    <jsp:include page="bootstrap-header.jsp"/>
</head>
<body>
<p/>
<div class="container" role="main">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Game Console</h3>
        </div>
        <div class="panel-body">
            <form action="???" method="post">
                <div class="form-group">
                    <label for="guess">Guess</label>
                    <input type="number"
                           class="form-control"
                           min="1" max="100"
                           id="guess"
                           value="${param.guess}"
                           name="guess"/>
                    <button class="btn btn-success">Play</button>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Game Statistics</h3>
        </div>
        <div class="panel-body">
             <table class="table table-bordered table-striped table-responsive table-hover">
                 <thead>
                    <tr>
                        <th>Guess</th>
                        <th>Message</th>
                    </tr>
                 </thead>
                 <tbody>
                    <tr>
                        <td>50</td>
                        <td>Pick Larger</td>
                    </tr>
                 </tbody>
             </table>
            <div class="form-group">
                <label for="wins">Wins</label>
                <span id="wins" class="badge">0</span>
            </div>
            <div class="form-group">
                <label for="loses">Loses</label>
                <span id="loses" class="badge">0</span>
            </div>
            <div class="form-group">
                <label for="total">Total</label>
                <span id="total" class="badge">0</span>
            </div>
            <div class="form-group">
                <label for="avgMoves">Average Moves</label>
                <span id="avgMoves" class="badge">0</span>
            </div>
            <div class="form-group">
                <label for="avgWinsTime">Average Wins Time</label>
                <span id="avgWinsTime" class="badge">0</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>