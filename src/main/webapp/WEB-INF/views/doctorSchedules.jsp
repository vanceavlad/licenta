<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="../../resources/css/daypilot/calendar_g.css" />
<link type="text/css" rel="stylesheet" href="../../resources/css/daypilot/calendar_green.css" />
<link type="text/css" rel="stylesheet" href="../../resources/css/daypilot/calendar_traditional.css" />
<link type="text/css" rel="stylesheet" href="../../resources/css/daypilot/calendar_transparent.css" />
<link type="text/css" rel="stylesheet" href="../../resources/css/daypilot/calendar_white.css" />

<script src="../../resources/js/daypilot-all.min.js"></script>
<script src="../../resources/jQuery/jquery-3.3.1.js"></script>


<div style="float:left; width: 160px;">
    <div id="nav"></div>
</div>
<div style="margin-left: 160px;">
    <div id="dp"></div>
</div>


<div class="space">CSS Theme:
    <select id="theme">
        <option value="calendar_default">Default</option>
        <option value="calendar_g">Google-Like</option>
        <option value="calendar_green">Green</option>
        <option value="calendar_traditional">Traditional</option>
        <option value="calendar_transparent">Transparent</option>
        <option value="calendar_white">White</option>
    </select>
</div>

<div class="export" style="float: left;">
<div class="space">
    Area:
    <select id="area">
        <option value="viewport">Viewport</option>
        <option value="full">Full</option>
    </select>

</div>
<div class="space">
    <a href="#" id="export-button">Export</a>
    <a href="#" id="download-button">Download</a>
    <a href="#" id="minimize-button">Minimize</a>
</div>
</div>

<div id="export"></div>

<script type="text/javascript">
    var nav = new DayPilot.Navigator("nav");
    nav.showMonths = 1;
    nav.skipMonths = 1;
    nav.selectMode = "week";
    nav.onTimeRangeSelected = function(args) {
        dp.startDate = args.day;
        dp.update();
        loadEvents();
    };
    nav.init();
</script>

<!-- calendar initialization and config -->
<script type="text/javascript">
    data = [
        {
            "id":"1",
            "text":"Calendar Event 1",
            "start":"2018-02-25T10:30:00",
            "end":"2018-02-25T16:30:00"
        },
        {
            "id":"2",
            "text":"Calendar Event 2",
            "start":"2018-02-24T09:00:00",
            "end":"2018-02-24T14:30:00"
        },
        {
            "id":"3",
            "text":"Calendar Event 3",
            "start":"2018-02-27T12:00:00",
            "end":"2018-02-27T16:00:00"
        }
    ];


    var dp = new DayPilot.Calendar("dp");
    dp.viewType = "Week";
//    dp.theme = "calendar_green";
    dp.init();

    dp.onEventMoved = function (args) {

        var update = {
            'id' : args.e.id(),
            'start' : args.newStart,
            'end' : args.newEnd,
            'doctorKey': '${doctor.uniqKey}'
        };
        console.log(update);
        $.ajax({
            type: 'POST',
            contentType : 'application/json',
            dataType: 'json',
            url: "/getSchedules/updateOnAction",
            data: JSON.stringify(update),
            success :function(result) {
              alert(result);
              dp.update();
            },
            error : function(xhr, status, error) {
                alert(status);
            }

        });
    };
    dp.onBeforeEventRender = function(args) {
        args.data.areas = [
            { top: 4, right: 4, icon: "../../resources/images/triangle-down.svg", visibility: "Hover", action: "ContextMenu", style: "font-size: 12px; background-color: #fff; border: 1px solid #ccc; padding: 2px 2px 0px 2px; cursor:pointer;"}
        ];
    };
    dp.contextMenu = new DayPilot.Menu({
        items: [
            {
                text: "Delete",
                onClick: function(args) {
                    var e = args.source;
                    var params = {
                        id: e.id()
                    };
                    alert(e.id());
                }
            }

        ]
    });

</script>

<script>

    function loadEvents() {
        var start = dp.visibleStart();
        var end = dp.visibleEnd();
        console.log(end);

        var search = {
            'start' : start,
            'end' : end,
            'doctorKey': '${doctor.uniqKey}'
        };

        console.log(search);
        $.ajax({
            type: 'POST',
            contentType : 'application/json',
            dataType: 'json',
            url: "/getSchedules/getSchedulesForDoctor",
            data: JSON.stringify(search),
            success :function(result) {
                console.log('resultat de pe server: ' + result.start);
                console.log('resultat de pe server: ' + result.end);
                dp.events.list = result;
                dp.update();
            },
            error : function(xhr, status, error) {
                alert(status);
            }

        });
    }

</script>

<script type="text/javascript">
    $(document).ready(function() {
        $("#theme").change(function(e) {
            dp.theme = this.value;
            dp.update();
        });
    });


    $(document).ready(function() {
        $("#export-button").click(function(ev) {
            ev.preventDefault();
            var area = $("#area").val();
            var element = dp.exportAs("svg", {area: area}).toElement();
            $("#export").html('').append(element);
        });
        $("#download-button").click(function(ev) {
            ev.preventDefault();
            var area = $("#area").val();
            dp.exportAs("svg", {area: area}).download();
        });
        $("#minimize-button").click(function(ev) {
            ev.preventDefault();
            var area = $("#area").val();
            $("#export").html('').append('');
        });
    });


</script>