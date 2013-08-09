function handleDrop(event, ui) {
	ui.draggable.fadeOut(function() {
		$(this).fadeIn();
	});

	$(this).droppable('disable');
}