import java.util.*

interface Command {
    fun execute(string: String)
}
enum class CommandType {
    CREATE,
    READ,
    DELETE;
}
// главная функция
fun main() {
    start()
    var str = converter()
    while(!(str.isBlank())){
        if(str == "readall"){
            readall()
        }
        else{ // TODO еще повозиться с массивом
            val command = getFirstWord(str)
            val arguments = getArguments(str)
            // val commands: Array<Command> = arrayOf()
            val commandIndex = CommandType.valueOf(command.uppercase(Locale.getDefault())).ordinal
            //commands[commandIndex].execute(arguments)
            if(command == "create"){
                create(arguments)
            } else if(command == "read"){
                read(arguments)
            } else if(command == "delete") {
                delete(arguments)
            } else {
                print("Команда введена направильно.")
            }
        }
        str = converter()
    }
}