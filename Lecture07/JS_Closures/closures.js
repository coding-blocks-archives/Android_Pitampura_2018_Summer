function fun1 (name) {
    console.log("fun1" + name)
    function fun2 () {
        console.log("fun2" + name)
    }

    return fun2
}

let f = fun1("XXX")
f()
f()

let g = fun1("GGG")
g()