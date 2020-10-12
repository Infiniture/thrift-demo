namespace java com.infiniture.thrift.demo.proto

service RPCDateService {
    string getDate(1:string userName)
}