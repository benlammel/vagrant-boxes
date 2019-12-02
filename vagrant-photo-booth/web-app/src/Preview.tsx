import React, { Component } from 'react';
import { Progress } from 'antd';
import './style.css';

interface AppProps {
    triggerAfterDone: any,
    counterInSeconds: number,
    pictureURI: string
}
interface AppState {
    timeRemainingInSeconds: number,
    timeRemainingInPercent: number
}

export default class Preview extends Component<AppProps, AppState> {

    constructor(props: AppProps){
        super(props);
        this.state = {
            timeRemainingInSeconds: this.props.counterInSeconds,
            timeRemainingInPercent: 100
        }
    }

    componentDidMount() {
        this.startCountdown();
        console.log("* " +this.props.pictureURI)
    }

    private startCountdown(){
        let counter = this.props.counterInSeconds;
        let interval = setInterval(() => {
            counter = counter - 1/100;

            if(counter < 0 ){
                clearInterval(interval);
                this.props.triggerAfterDone();
            }else {
                this.setState({
                    timeRemainingInSeconds: counter,
                    timeRemainingInPercent: Math.round(this.state.timeRemainingInSeconds/this.props.counterInSeconds *100)
                })
            }
        }, 10);

    }

    render() {

        return (
            <div className="centered">
                <img src={this.props.pictureURI} className="fullImg" alt="" />
                <Progress percent={this.state.timeRemainingInPercent} showInfo={false} />
            </div>);
    }

}
