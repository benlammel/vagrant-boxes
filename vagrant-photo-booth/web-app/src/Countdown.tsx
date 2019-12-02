import React, { Component } from 'react';
import { Progress } from 'antd';
import './style.css';

interface AppProps {
    triggerAfterDone: any,
    triggerForCapture: any,
    counterInSeconds: number
}
interface AppState {
    timeRemainingInSeconds: number
}

export default class Countdown extends Component<AppProps, AppState> {

    constructor(props: AppProps){
        super(props);
        this.state = {
            timeRemainingInSeconds: this.props.counterInSeconds
        }
    }

    componentDidMount() {
        this.startCountdown();
    }

    private startCountdown(){
        let counter = this.props.counterInSeconds;
        let triggerSent: boolean = false;
        let interval = setInterval(() => {
            counter = counter - 1/100;

            if(counter< this.props.counterInSeconds*0.5
                && !triggerSent){
                this.props.triggerForCapture();
                triggerSent = true;
            }

            if(counter < 0 ){
                clearInterval(interval);
                this.props.triggerAfterDone();
            }else {
                this.setState({
                    timeRemainingInSeconds: counter
                })
            }
        }, 10);
    }

    render() {

        return (
            <div className="centered">
                <Progress type="circle" percent={this.state.timeRemainingInSeconds/this.props.counterInSeconds *100} format={percent => `${Math.round(this.state.timeRemainingInSeconds)} s`} />
            </div>);
    }

}
