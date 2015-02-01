$(function() {
	$(".level").click(function (e) {
		var $link = $(this);
		console.log($link[0].id);
		e.stopPropagation();
	});	
	
	function getLevelStatusTemplate(status, progressPercentage) {
		var template = '<i class="level-ico level-ico-s  level-ico-'+status+'"></i>';
		template += '<div class="level-status">';
		if (status == 'plant') {
			template += '<span class="ico ico-complete ico-correct ico-m ico-green"></span>';
		} else if (status == 'seed') {
			template += '<div class="progress"><div class="bar bar-success" style="width: ' + progressPercentage + ';"></div></div>';
		} else {
			template += 'Ready to learn';
		}
		template += '</div>';
		return template;
	}
	
	function getDisplayLevelTemplate(levelObj) {
		var template = '<a id="' + levelObj.id + '" href="/details/" class="level clearfix"><div class="level-index">' + levelObj.id + '</div><div class="level-icon">';
		template += getLevelStatusTemplate(levelObj.status, levelObj.progressPercentage);
		template += '</div><div class="level-title">' + levelObj.title + '</div><div class="level-actions hidden"></div>';
		return template;
	}
	
	var $levels = $('#main-levels');

	
	function loadLevel() {
		var result = [];
		result.push({
			id: 'cz',
			title: 'testing...',
			status: 'seed',
			progressPercentage: '33%'
		});
		
		result.push({
			id: 'cz1',
			title: 'testing...',
			status: 'seed',
			progressPercentage: '33%'
		});
		
		result.push({
			id: 'cz2',
			title: 'testing...',
			status: 'plant',
			progressPercentage: '33%'
		});
		
		result.push({
			id: 'cz3',
			title: 'testing...',
			status: 'inactive',
			progressPercentage: '33%'
		});
		
		return result;
	}
	
	loadLevel().forEach(function(item) {
		var t = getDisplayLevelTemplate(item);
		//$levels.append(t);
	});
	

});