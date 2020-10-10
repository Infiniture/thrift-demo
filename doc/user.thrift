namespace java com.infiniture.thrift.demo.proto.user

service UserService {
    string getName(1:i32 id)
    bool isExist(1:string name)
}