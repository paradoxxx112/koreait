function write(title){
    const title = document.getElementsByName('title').value;
    if(title == "" || title == null && title.value.length){
        alert('글 제목을 입력하세요');
    }

}