echo “---------------------”
echo “请先进入deploy 和 plat 文件夹 执行”
echo “mvn -Dmaven.test.skip=true package deploy”
echo “打包完成后再执行此脚本”
echo “---------------------”

cd deploy && mvn -Dmaven.test.skip=true clean install && cd ../plat && mvn -Dmaven.test.skip=true clean install&& cd ../www && mvn -Dmaven.test.skip=true clean package && cd ../portal && mvn -Dmaven.test.skip=true clean package && cd ../monitor && mvn -Dmaven.test.skip=true clean package && cd ../eureka && mvn -Dmaven.test.skip=true clean package && cd ../login && mvn -Dmaven.test.skip=true clean package && echo "build all success..."

