
    var refreshActive = true;

	function refreshGrid() {
    	if (refreshActive) {
		    $.ajax({
    			url : 'gridRefresh',
    			success : function(data) {
    				$('#eventGrid').html(data);
    			 }
    			});
    	    }
	}

	function goSearchGrid() {
	        var paddedEventNumber = "eventNumber=" + $('#eventNumber').val();
	        refreshActive=false;

    		$.ajax({
    		    url : 'searchGrid',
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

    function resetSearch() {
            $('#eventNumber').val('');
            refreshActive = true;
            refreshGrid();
    }

