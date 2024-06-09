/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    let t = Date.now()
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(Date.now() - 1)
        }, millis)
    })
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */