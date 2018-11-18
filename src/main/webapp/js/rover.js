function setPlateau() {
    var plateau = $("#plateau").val();
    if (plateau !== '') {
        $.ajax({
            url: "plateau",
            type: "POST",
            data: {'plateau': plateau},
            dataType: 'json',
            async: true,
            success: function (data) {
                if (data.status === true) {
                    $("#inputValues").val(data.message);
                } else {
                    alert(data.message);
                }
            }
        });
    } else {
        alert("Please enter a value");
    }
}

function setPosition() {
    var position = $("#position").val();
    if (position !== '') {
        $.ajax({
            url: "position",
            type: "POST",
            data: {'position': position},
            dataType: 'json',
            async: true,
            success: function (data) {
                if (data.status === true) {
                    var current = $("#inputValues").val();
                    $("#inputValues").val(current + '\n' + data.message);
                } else {
                    alert(data.message);
                }
            }
        });
    } else {
        alert("Please enter a value");
    }
}

function moveRover() {
    var movement = $("#movement").val();
    if (movement !== '') {
        $.ajax({
            url: "movement",
            type: "POST",
            data: {'movement': movement},
            dataType: 'json',
            async: true,
            success: function (data) {
                if (data.status === true) {
                    var current = $("#inputValues").val();
                    $("#inputValues").val(current + '\n' + 'Rover moved using ' + movement);

                    var currentOutput = $("#outputValues").val();
                    $("#outputValues").val(currentOutput + '\n' + data.message);
                } else {
                    alert(data.message);
                }
            }
        });
    } else {
        alert("Please enter a value");
    }
}