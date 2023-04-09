var get_data = function(test_data) {
    var data = {
        test_data: test_data
    }

    var url = "/api/get_data.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            if (resp.data.length == 0) {
                alert("no data");
                return;
            }

            alert("no data = " + JSON.stringify(resp.data));
            //...
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

var add_data = function(test_data) {
    var data = {
        test_data: test_data
    }

    var url = "/api/add_data.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            //...
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

var modify_data = function(id, test_data) {        
    var data = {
        id: id,
        test_data: test_data
    }

    var url = "/api/modify_data.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            //...
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

var delete_data = function(id) {        
    var data = {
        id: id
    }

    var url = "/api/delete_data.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            //...
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

var log_out = function(id) {        
    var url = "/api/log_out.do";
    $.ajax({
        type: "GET",
        url: url,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            window.location.href = "/login";
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

$("#btn_select_1").click(function(){
    alert("btn_select_1");
    get_data('1');
});

$("#btn_insert_1").click(function(){
    alert("btn_insert_1");
    add_data(Math.random());
});

$("#btn_update_1").click(function(){
    alert("btn_update_1");
    modify_data(1, Math.random());
});

$("#btn_delete_1").click(function(){
    alert("btn_delete_1");
    delete_data(2);
});

$("#btn_logout_1").click(function(){
    alert("btn_logout_1");
    log_out();
});

$(document).ready(function(){
    alert("$(document).ready()");
    //...
});

