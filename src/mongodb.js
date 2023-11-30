const mongoose=require("mongoose")

mongoose.connect("mongodb+srv://PaolaNastasio:WEBsite99911226@cluster0.v2kyq2z.mongodb.net/")

.then(() => {
console.log("mongodb connected");
})
.catch(() => {
console.log("failed to connect");
})


const LoginSchema=new mongoose.Schema ({
    email: {
        type: String, 
        required: true
    },
    password: {
        type: String, 
        required: true
    }
    })

    const collection=new mongoose.model("costumers",LoginSchema)