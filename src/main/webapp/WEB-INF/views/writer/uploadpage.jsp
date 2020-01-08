<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="http://malsup.github.com/jquery.form.js"></script> 


<style>
            .upload-list{
                list-style-type: none;
                
            }
            .list{
                width:1280px;
                height:300px;
            }
            .left{
                width:300px;
                height: 300px;

            }
            .right{
                width:500px;
                height:300px;
            }
            .left,.right{
                float: left;
            }
            li{
                list-style-type: none;
            }
            .img{
            padding: 10px;
            width:250px;
            margin:auto;
            }
            .img>img{
            width:100%;
            height:100%;
            }
            .left>input{
            width:100%;
            }
            .tag-item {
                display:inline-block;
                color: #000;
                margin: 3px 5px;
                border:1px solid black;
                padding: 3px;
                border-radius: 3px;
            }
            input[type=radio]{
                display:none;
                background-color:transparent;
            }

            label{
               display:inline-block;
                margin:0 10px;
                border: 1px solid black;
                border-radius: 3px;
                width:80px;
                height:30px;
                text-align: center;
                line-height: 30px;
            }
            .tag-del{
                background-color: transparent;
                border:none;
            }
            input[type=radio]:checked+label{
            background-color:gray;
            }
        </style>
</head>
<body>
<div class="app">
            <form id="uploadform" action="${pageContext.request.contextPath}/writer/upload" method="post" enctype="multipart/form-data">
                <button type="button" class="add-item">ADD</button>
                <input type="hidden" value="" name="tag" id="rdTag" />
                <ul class="upload-list">
                </ul>
                <button type="submit">upload</button>
            </form>
        </div>
        <script>

            var addButton = document.getElementsByClassName('add-item')[0]
            var list = document.getElementsByClassName('upload-list')[0]
            var count = 0

            function readImage(files, cnt, thumb) {
                var reader = new FileReader()
                
                reader.onload = function(e) {
                	
                    var data = e.target.result
                    var img = new Image()
                    //img.width = 100%;
                    img.src = data
                    thumb.innerHTML = ''
                    thumb.appendChild(img)
                };
                if (files && files[0]) reader.readAsDataURL(files[0])
            };

            function leftTemplate(cnt) {
                var left = document.createElement('div')
                var input = document.createElement('input')
                var thumb = document.createElement('div')
                thumb.classList.add("img")
                left.classList.add('left')
                input.setAttribute('type', 'file')
                input.setAttribute('name', 'file')
                input.onchange = function(e) {
                    readImage(e.target.files, cnt, thumb)
                }
                left.appendChild(input)
                left.appendChild(thumb)
                return left
            }

            function rightTemplate(cnt) {
                var right = document.createElement('div')
                var commercial = document.createElement('div')
			    var tags = document.createElement('div')
			    var tagView = document.createElement('ul')
			    var tagInput = document.createElement('input')

                var usage = '<div class=usage><p>어떤용도로 판매하시겠습니까?</p></div>'
                var copyright = '<div class=copyright><p>재산권 및 초상권에 대한 정보를 적어주세요</p><textarea name="copyright"></textarea></div>'
                var tag = '<div class="tag"><p>최소 5개이상의 태그를 적어주세요</p></div>'
                var radio = '' +
				'<input type="radio" id="p' + cnt + '-c" name="p' + cnt + '-commercial" value=상업용 >' +
				'<label for="p' + cnt + '-c">상업용</label>' +
				'<input type="radio" id="p' + cnt + '-nc" name="p' + cnt + '-commercial" value=비상업용 >' +
				'<label for="p' + cnt + '-nc">비상업용</label>'

                var tagList = []

                tagInput.setAttribute('type', 'text')
                right.classList.add('right')
                tagInput.onkeypress = function(e) { 
				addTags(e, cnt, tagView, tagList) 
			    }
                
               
                commercial.innerHTML = radio
                tags.appendChild(tagInput)
                tags.appendChild(tagView)
                right.innerHTML = usage
			    right.appendChild(commercial)
                right.innerHTML += copyright
                right.innerHTML += tag
			    right.appendChild(tags)
			    return right
                }

            function setItem() {
                var item = document.createElement('li')
                var remove = document.createElement('button')
                var left = leftTemplate(count)
                var right = rightTemplate(count)

                item.classList.add('list')
                remove.textContent = 'X'
                remove.classList.add('rm'+count)
                remove.onclick = function() {
                    list.removeChild(item)
                }

                item.appendChild(remove)
                item.appendChild(left)
                item.appendChild(right)
                list.appendChild(item)
                count++
                
                if(count>=10){
                	alert("최대 10개까지 업로드 가능합니다")
                }
            }

            addButton.addEventListener('click', setItem)
            setItem()

            function addTags(e, cnt, view, list) {
			if (e.key === 'Enter') {
				e.preventDefault()
				if (!e.target.value) {
					alert('태그를 입력해주세요')
					return false
				}
				var value = e.target.value.replace(/ +/g, '')
               
                var overlap = list.reduce(function(a, c) { 
					!a && (a = c === value)
					return a
				 }, false)
				if (overlap) {
					alert('overlap tag !!!!')
					return false
				}

				var item = document.createElement('li')
				var tag = '' +
					'<input type="hidden" name="p'+cnt+'-tags[]" value="'+value+'">' +
					'<span>#'+value+'</span>'
				var remove = document.createElement('button')
				remove.textContent = 'X'
				remove.onclick = function() {
					view.removeChild(item)
				}

                remove.classList.add('tag-del')
				item.innerHTML = tag
                item.classList.add('tag-item')
				item.appendChild(remove)
				view.appendChild(item)
                e.target.value='';
			}
		}
           
            function getExif(file) {
            	  const reader = new FileReader()
            	  const imageViewer = document.getElementByTagName(img)
            	  const image = file.files[0]

            	  reader.onload = e => {
            	    EXIF.getData(image, () => {
            	      const tags = EXIF.getAllTags(image)

            	      // metadata 출력
            	      console.log(tags)

            	      // 이미지 미리보기
            	      imageViewer.style.backgroundImage = `url(${e.target.result})`
            	    })
            	  }

            	  reader.readAsDataURL(image)
            	}   

        </script>

</body>
</html>
