
    var refreshActive = true;

	function refreshEventGrid() {
    	if (refreshActive) {
		    $.ajax({
    			url : 'eventGridRefresh',
    			success : function(data) {
    				$('#eventGrid').html(data);
    			 }
    			});
    	    }
	}

	function goSearchEventGrid() {
	        var paddedEventNumber = "eventNumber=" + $('#eventNumber').val();
	        refreshActive=false;

    		$.ajax({
    		    url : 'searchEventGrid',
    		    type : 'POST',
    			data : paddedEventNumber,
    			success : function(data) {
    				$('#eventGrid').html(data);
    			},
    			error: function(data, errorMessage) {
    			    alert('Invalid Search Data: ' + errorMessage);
    			}
    		});
    }

    function resetEventSearch() {
            $('#eventNumber').val('');
            refreshActive = true;
            refreshEventGrid();
    }

	function goSearchTaskGrid() {
	        var paddedTaskNumber = "taskNumber=" + $('#taskNumber').val();
	        refreshActive=false;

    		$.ajax({
    		    url : 'searchTaskGrid',
    		    type : 'POST',
    			data : paddedTaskNumber,
    			success : function(data) {
    				$('#taskGrid').html(data);
    			},
    			error: function(data, errorMessage) {
    			    alert('Invalid Search Data: ' + errorMessage);
    			}
    		});
    }

    function resetTaskSearch() {
            $('#taskNumber').val('');
            refreshActive = true;
            refreshGrid();
    }

	function refreshTaskGrid() {
    	if (refreshActive) {
		    $.ajax({
    			url : 'taskGridRefresh',
    			success : function(data) {
    				$('#taskGrid').html(data);
    			 }
    			});
    	    }
	}
