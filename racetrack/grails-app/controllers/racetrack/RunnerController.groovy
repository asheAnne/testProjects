package racetrack

class RunnerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [runnerInstanceList: Runner.list(params), runnerInstanceTotal: Runner.count()]
    }

    def create = {
        def runnerInstance = new Runner()
        runnerInstance.properties = params
        return [runnerInstance: runnerInstance]
    }

    def save = {
        def runnerInstance = new Runner(params)
        if (runnerInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'runner.label', default: 'Runner'), runnerInstance.id])}"
            redirect(action: "show", id: runnerInstance.id)
        }
        else {
            render(view: "create", model: [runnerInstance: runnerInstance])
        }
    }

    def show = {
        def runnerInstance = Runner.get(params.id)
        if (!runnerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
            redirect(action: "list")
        }
        else {
            [runnerInstance: runnerInstance]
        }
    }

    def edit = {
        def runnerInstance = Runner.get(params.id)
        if (!runnerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [runnerInstance: runnerInstance]
        }
    }

    def update = {
        def runnerInstance = Runner.get(params.id)
        if (runnerInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (runnerInstance.version > version) {

                    runnerInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'runner.label', default: 'Runner')] as Object[], "Another user has updated this Runner while you were editing")
                    render(view: "edit", model: [runnerInstance: runnerInstance])
                    return
                }
            }
            runnerInstance.properties = params
            if (!runnerInstance.hasErrors() && runnerInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'runner.label', default: 'Runner'), runnerInstance.id])}"
                redirect(action: "show", id: runnerInstance.id)
            }
            else {
                render(view: "edit", model: [runnerInstance: runnerInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def runnerInstance = Runner.get(params.id)
        if (runnerInstance) {
            try {
                runnerInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])}"
            redirect(action: "list")
        }
    }
}
