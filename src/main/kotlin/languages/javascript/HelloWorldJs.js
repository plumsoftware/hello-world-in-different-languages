function helloWorldJava() {
    const message = "Hello world from JavaScript";
    return Buffer.from(message);
}

const byteArray = helloWorldJava();
process.stdout.write(byteArray);
