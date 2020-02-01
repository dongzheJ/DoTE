function get(url,success){
  wx.request({
    url: url,
    header: {
      'content-type': 'json'
    },
    success: function (res) {
      success(res.data);
    }
  })
}


module.exports = {
  get: get
}