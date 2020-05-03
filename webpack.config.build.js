module.exports = {
    mode: 'production',
    entry: "./webpack/entry.js",
    output: {
        path: __dirname + '/assets/javascripts/',
        filename: "bundle.js"
    },
    module: {
      rules: [
        {
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            use: {
              loader: "babel-loader"
            }
          }
      ]
    }
  };
  