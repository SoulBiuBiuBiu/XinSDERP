
	//主表格提交
	function main_form_submit(form_name) {

		$.post($('#Context_Submit_From').attr("action"), $('#Context_Submit_From').serialize(), function(res) {
			if(!res.status) {
				$.messager.show({
					title: '错误提示',
					msg: res.info,
					timeout: 2000,
					showType: 'slide'
				});
			} else {
				$.messager.show({
					title: '成功提示',
					msg: res.info,
					timeout: 1000,
					showType: 'slide'
				});
				//			UpdateTabs(Model_name, res.url+'&cachedata='+new Date().getTime(), '', 'iconfont icon-viewlist');
				$('#Context_id').val(res.id); //赋值新增的信息的ID号
				//按钮控制代码
				$('#main_save_btn').linkbutton('disable');
				//				$('#text_add_btn').linkbutton('enable');
			}
		})

	}
	//文本信息新增
	function text_data_add() {
		layer.open({
			title: '文本信息',
			type: 1,
			area: ['400px', '300px'],
			content: '<table cellpadding="2" cellspacing="2" width="100%"><tbody>' +
				'<tr><td>标题:</td><td><input type="text" class="input" id="text_title" style="width:200px;"></td></tr>' +
				'<tr><td>内容:</td><td><textarea type="text" class="input" id="text_context" style="width:280px;height:150px;"></textarea></td></tr>' +
				'</table>',
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				var title = $('#text_title').val();
				var context = $('#text_context').val();
				var refno = $('#Context_id').val(); //信息的主键
				if(title.trim() == '') {
					layer.alert('请填写标题！', {
						icon: 7
					});
					return false;
				}
				if(context.trim() == '') {
					layer.alert('请填写内容！', {
						icon: 7
					});
					return false;
				}

				$.post("{:U('handle')}", {
					"refno": refno,
					"title": title,
					"context": context,
					"type":1
				}, function(data) {
					var json = eval(data);
					//					console.log(json);
					if(json.status) {
						layer.msg('文本信息添加成功！');
						var tr = document.createElement('tr');
						tr.innerHTML = "<td>" + title + "</td>" +
							'<td>' + context.substr(0, 40) + '...</td>' +
							"<td><a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
						$('#text_body').append(tr);
						//$(o).parent().prev().prev().prev().prev().prev().prev().html('<span class="label label-info">已发货</span>');

					} else {
						layer.msg(json.info);
					}
				});

				//按钮【按钮一】的回调
				layer.close(index); //如果设定了yes回调，需进行手工关闭
			}
		});
	}
	//图片信息新增
	function pic_data_add() {
		var refno = $('#Context_id').val(); //信息的主键
		layer.open({
			title: '图片信息',
			type: 2,
			area: ['800px', '600px'],
			content: "{:U('upload')}",
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				var body = layer.getChildFrame('body', index);
				var savepath = body.find('#item_savepath').val();
				var image = body.find('#item_image').val();
				if(image == '') {
					layer.msg('请上传图片！');
				} else {
					var title = body.find('#item_title').val();
					$.post("{:U('handle')}", {
						"refno": refno,
						"title": title,
						"savepath": savepath,
						"image": image,
						"type":2
					}, function(data) {
						var json = eval(data);
						if(json.status) {
							layer.msg('图片信息添加成功！');
							var tr = document.createElement('tr');
							tr.innerHTML = "<td><img src='__PUBLIC__" + savepath + image+" style='width:40px;height:40px;'/></td>" +
								'<td>' + title + '</td>' +
								"<td><a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
							$('#pic_body').append(tr);
						} else {
							layer.msg(json.info);
						}
					});
					layer.close(index); //如果设定了yes回调，需进行手工关闭
				}
			}
		});
	}
	//视频信息新增
	function video_data_add() {
      layer.open({
			title: '视频信息',
			type: 1,
			area: ['400px', '200px'],
			content: '<table cellpadding="2" cellspacing="2" width="100%"><tbody>' +
				'<tr><td width="80px">视频名称:</td><td><input type="text" class="input" id="video_title" style="width:200px;"></td></tr>' +
				'<tr><td>视频文件名:</td><td><input type="text" class="input" id="video_image" style="width:200px;"></td></tr>'+
				'<tr><td></td><td style="color:red;">提示：视频ftp上传到根目录下的video目录下，<br>这边填写视频文件名称。</td></tr>' +
				'</table>',
			btn: ['确定', '取消'],
			yes: function(index, layero) {
				var title = $('#video_title').val();
				var filename = $('#video_image').val();
				var refno = $('#Context_id').val(); //信息的主键
				if(title.trim() == '') {
					layer.alert('视频名称！', {
						icon: 7
					});
					return false;
				}
				if(filename.trim() == '') {
					layer.alert('请填写视频文件名！', {
						icon: 7
					});
					return false;
				}

				$.post("{:U('handle')}", {
					"refno": refno,
					"title": title,
					"type":3,
					"image": filename
				}, function(data) {
					var json = eval(data);
					//					console.log(json);
					if(json.status) {
						layer.msg('文本信息添加成功！');
						var tr = document.createElement('tr');
						tr.innerHTML = "<td>" + title + "</td>" +
							"<td><a  href='#' onclick=\"record_delete(this," + json.id + ")\">删除</a></td>";
						$('#video_body').append(tr);

					} else {
						layer.msg(json.info);
					}
				});

				//按钮【按钮一】的回调
				layer.close(index); //如果设定了yes回调，需进行手工关闭
			}
		});
	}

	function record_delete(o, id) {
		layer.confirm('你确定要删除此记录吗？', {
			btn: ['确定', '取消'] //按钮
		}, function() {
			layer.closeAll();
			$.post("{:U('itemdelete')}", {
				"id": id
			}, function(data) {
				var json = eval(data);
				if(json.status) {
					layer.msg('删除成功！');
					$(o).parent().parent().remove(); //界面删除这行
				} else {
					layer.msg(json.info);
				}
			});
		});

	}