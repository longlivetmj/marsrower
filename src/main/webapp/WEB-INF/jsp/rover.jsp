<html>
<head>
    <title>Mars Rower</title>
    <link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="../../js/rover.js"></script>
</head>
<body>
<div class="col-md-12">
    <h3>Mas Rover</h3>
</div>
<div class="card container-fluid">
    <div class="row card-body">
        <div class="col-md-6 row">
            <div class="row">
                <label class="col-md-3 col-xs-12 control-label" for="plateau">Plateau</label>
                <div class="col-md-6 col-xs-12">
                    <input type="text" id="plateau" name="plateau" class="form-control w-auto"/>
                </div>
                <div class="col-md-2 col-xs-12">
                    <button type="button" class="btn btn-danger" onclick="setPlateau()">SET PLATEAU</button>
                </div>
            </div>
            <div class="row">
                <label class="col-md-3 col-xs-12 control-label" for="position">Position</label>
                <div class="col-md-6 col-xs-12">
                    <input type="text" id="position" name="position" class="form-control w-auto"/>
                </div>
                <div class="col-md-2 col-xs-12">
                    <button type="button" class="btn btn-primary" onclick="setPosition()">SET POSITION</button>
                </div>
            </div>
            <div class="row">
                <label class="col-md-3 col-xs-12 control-label" for="movement">Movement</label>
                <div class="col-md-6 col-xs-12">
                    <input type="text" id="movement" name="movement" class="form-control w-auto"/>
                </div>
                <div class="col-md-2 col-xs-12">
                    <button type="button" class="btn btn-success" onclick="moveRover()">MOVE ROVER</button>
                </div>
            </div>
        </div>
        <div class="col-md-3 align-content-center">
            <h4>Input Values</h4>
            <div class="form-group">
                <textarea id="inputValues" name="inputValues" class="form-control" rows="10"></textarea>
            </div>
        </div>
        <div class="col-md-3 align-items-center">
            <h4>Output Values</h4>
            <div class="form-group">
                <textarea id="outputValues" name="outputValues" class="form-control" rows="10"></textarea>
            </div>
        </div>
    </div>
</div>
</body>
</html>