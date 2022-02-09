环境配置:

1. ```bash
   npm install -g @vue/cli
   ```

2. 下载 https://github.com/protocolbuffers/protobuf/releases

3. 设置系统变量

---

protoc安装:

1. ```
   protoc --java_out=./src/main/java src/main/java/github/nooblong/auth/Auth.proto
   ```

2. npm install axios protobufjs --save-dev

3. `protobufjs`提供了一个叫pbjs的工具，这是一个神器，根据参数不同可以打包成xx.json或xx.js文件。比如我们想打包成json文件，在根目录运行：

   ```awk
   npx pbjs -t json src/proto/*.proto > src/proto/proto.json
   ```


   实践证明打包成js模块才是最好用的。我这里直接给出最终的命令

   ```awk
   npx pbjs -t json-module -w commonjs -o src/proto/proto.js  src/proto/*.proto
   ```

​		`-w`参数可以指定打包js的包装器

4. 