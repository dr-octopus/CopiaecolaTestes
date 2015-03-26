$('.accordion .ac-header').on('click', function() {
	var acItem = $(this).parent();
	var clazz = 'aberto';
	
	if (acItem.hasClass(clazz)) {
		acItem.removeClass(clazz);
	} else {
		acItem.addClass(clazz);
	}
	
	acItem.find('.ac-content').slideToggle(200);
});
