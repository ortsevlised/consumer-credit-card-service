import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method('POST')
        url '/credit-scores'
        body(
                "citizenNumber": 4444,
                "requestDate": anyDate(),
                "uuid": $(consumer(anyUuid()), producer("d1b8242f-f755-403d-9f36-f4d5fdb109b2"))
        )
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body(
                "score": "LOW",
                "uuid": $(consumer(fromRequest().body('$.uuid')), producer("d1b8242f-f755-403d-9f36-f4d5fdb109b2"))
        )
        headers {
            contentType applicationJson()
        }
    }
}