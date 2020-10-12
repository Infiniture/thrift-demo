namespace java com.infiniture.thriftserver.proto

service RPCDateService {
    string getDate(1:string userName)
}